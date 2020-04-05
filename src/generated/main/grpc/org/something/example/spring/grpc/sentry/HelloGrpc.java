package org.something.example.spring.grpc.sentry;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: hello.proto")
public final class HelloGrpc {

  private HelloGrpc() {}

  public static final String SERVICE_NAME = "org.something.example.spring.grpc.sentry.Hello";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.something.example.spring.grpc.sentry.HiRequest,
      org.something.example.spring.grpc.sentry.HiResponse> getHiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Hi",
      requestType = org.something.example.spring.grpc.sentry.HiRequest.class,
      responseType = org.something.example.spring.grpc.sentry.HiResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.something.example.spring.grpc.sentry.HiRequest,
      org.something.example.spring.grpc.sentry.HiResponse> getHiMethod() {
    io.grpc.MethodDescriptor<org.something.example.spring.grpc.sentry.HiRequest, org.something.example.spring.grpc.sentry.HiResponse> getHiMethod;
    if ((getHiMethod = HelloGrpc.getHiMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getHiMethod = HelloGrpc.getHiMethod) == null) {
          HelloGrpc.getHiMethod = getHiMethod =
              io.grpc.MethodDescriptor.<org.something.example.spring.grpc.sentry.HiRequest, org.something.example.spring.grpc.sentry.HiResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Hi"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.something.example.spring.grpc.sentry.HiRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.something.example.spring.grpc.sentry.HiResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloMethodDescriptorSupplier("Hi"))
              .build();
        }
      }
    }
    return getHiMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloStub>() {
        @java.lang.Override
        public HelloStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloStub(channel, callOptions);
        }
      };
    return HelloStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloBlockingStub>() {
        @java.lang.Override
        public HelloBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloBlockingStub(channel, callOptions);
        }
      };
    return HelloBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloFutureStub>() {
        @java.lang.Override
        public HelloFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloFutureStub(channel, callOptions);
        }
      };
    return HelloFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HelloImplBase implements io.grpc.BindableService {

    /**
     */
    public void hi(org.something.example.spring.grpc.sentry.HiRequest request,
        io.grpc.stub.StreamObserver<org.something.example.spring.grpc.sentry.HiResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHiMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHiMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.something.example.spring.grpc.sentry.HiRequest,
                org.something.example.spring.grpc.sentry.HiResponse>(
                  this, METHODID_HI)))
          .build();
    }
  }

  /**
   */
  public static final class HelloStub extends io.grpc.stub.AbstractAsyncStub<HelloStub> {
    private HelloStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloStub(channel, callOptions);
    }

    /**
     */
    public void hi(org.something.example.spring.grpc.sentry.HiRequest request,
        io.grpc.stub.StreamObserver<org.something.example.spring.grpc.sentry.HiResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHiMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HelloBlockingStub extends io.grpc.stub.AbstractBlockingStub<HelloBlockingStub> {
    private HelloBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.something.example.spring.grpc.sentry.HiResponse hi(org.something.example.spring.grpc.sentry.HiRequest request) {
      return blockingUnaryCall(
          getChannel(), getHiMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HelloFutureStub extends io.grpc.stub.AbstractFutureStub<HelloFutureStub> {
    private HelloFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.something.example.spring.grpc.sentry.HiResponse> hi(
        org.something.example.spring.grpc.sentry.HiRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHiMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HI = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HelloImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HI:
          serviceImpl.hi((org.something.example.spring.grpc.sentry.HiRequest) request,
              (io.grpc.stub.StreamObserver<org.something.example.spring.grpc.sentry.HiResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HelloBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.something.example.spring.grpc.sentry.HelloOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Hello");
    }
  }

  private static final class HelloFileDescriptorSupplier
      extends HelloBaseDescriptorSupplier {
    HelloFileDescriptorSupplier() {}
  }

  private static final class HelloMethodDescriptorSupplier
      extends HelloBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HelloMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HelloGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloFileDescriptorSupplier())
              .addMethod(getHiMethod())
              .build();
        }
      }
    }
    return result;
  }
}
