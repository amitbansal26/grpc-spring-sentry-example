package com.something.example.spring.grpc.sentry;

import com.something.example.spring.grpc.sentry.adapter.HelloGrpcAPI;
import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.something.example.spring.grpc.sentry.HelloGrpc;
import org.something.example.spring.grpc.sentry.HiRequest;
import org.something.example.spring.grpc.sentry.HiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class GrpcSpringSentryExampleApplicationTests {

	@Autowired
	private HelloGrpcAPI helloGrpcAPI;

	private static ManagedChannel managedChannel;

	@BeforeEach
	void init() throws IOException {
		var cleanupRule = new GrpcCleanupRule();
		var name = InProcessServerBuilder.generateName();
		var server = InProcessServerBuilder
				.forName(name)
				.directExecutor()
				.addService(helloGrpcAPI)
				.build()
				.start();

		cleanupRule.register(server);
		managedChannel = cleanupRule.register(InProcessChannelBuilder.forName(name).directExecutor().build());
	}

	@Test
	void should_answer_to_hello_with_non_empty_phrase() {
		//given
		final var stub = HelloGrpc.newBlockingStub(managedChannel);
		var request = HiRequest.newBuilder()
				.setPhrase("Hi there")
				.build();

		//when
		HiResponse answer = stub.hi(request);

		//then
		Assertions.assertFalse(StringUtils.isBlank(answer.getPhrase()));
	}

}
