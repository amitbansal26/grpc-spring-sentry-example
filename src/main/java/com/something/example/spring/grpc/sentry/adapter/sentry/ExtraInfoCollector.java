package com.something.example.spring.grpc.sentry.adapter.sentry;

import io.grpc.Attributes;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.sentry.SentryClient;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class ExtraInfoCollector {
    private final SentryClient client;

    public void recordMessage(Object message) {
        record("message", Optional.of(message).map(Object::toString).orElse(""));
    }

    public void recordMetadata(Metadata metadata) {
        for (String key : metadata.keys()) {
            var iterable = metadata.getAll(Metadata.Key.of(key, Metadata.ASCII_STRING_MARSHALLER));
            String value = StreamSupport.stream(iterable.spliterator(), false)
                    .collect(Collectors.joining(","));
            record(key, value);
        }
    }

    public <ReqT, RespT> void recordCallData(ServerCall<ReqT, RespT> call) {
        record("call-addressed", call.getAuthority());

        var methodDescriptor = call.getMethodDescriptor();
        record("service", methodDescriptor.getServiceName());
        record("method", methodDescriptor.getFullMethodName());

        Attributes attributes = call.getAttributes();
        //since there were no point in visibility-restriction attributes content but for some reason they still deprecate this method
        for (Attributes.Key key : attributes.keys()) {
            record(key.toString(), attributes.get(key));
        }
    }

    private void record(String key, Object value) {
        client.getContext().addExtra(key, value);
    }

    public void recordContext(Context context) {
        record("deadlineRemainingMs", Optional.ofNullable(context.getDeadline())
                .map(dl -> dl.timeRemaining(TimeUnit.MILLISECONDS))
                .map(dl -> Long.toString(dl))
                .orElse("-1")
        );
    }

}
