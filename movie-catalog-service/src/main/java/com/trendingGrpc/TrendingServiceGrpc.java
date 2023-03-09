package com.trendingGrpc;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: trendingService.proto")
public final class TrendingServiceGrpc {

  private TrendingServiceGrpc() {}

  public static final String SERVICE_NAME = "com.trendingGrpc.TrendingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.trendingGrpc.TrendingRequest,
      com.trendingGrpc.TrendingResponse> getGetTop10MoviesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTop10Movies",
      requestType = com.trendingGrpc.TrendingRequest.class,
      responseType = com.trendingGrpc.TrendingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.trendingGrpc.TrendingRequest,
      com.trendingGrpc.TrendingResponse> getGetTop10MoviesMethod() {
    io.grpc.MethodDescriptor<com.trendingGrpc.TrendingRequest, com.trendingGrpc.TrendingResponse> getGetTop10MoviesMethod;
    if ((getGetTop10MoviesMethod = TrendingServiceGrpc.getGetTop10MoviesMethod) == null) {
      synchronized (TrendingServiceGrpc.class) {
        if ((getGetTop10MoviesMethod = TrendingServiceGrpc.getGetTop10MoviesMethod) == null) {
          TrendingServiceGrpc.getGetTop10MoviesMethod = getGetTop10MoviesMethod = 
              io.grpc.MethodDescriptor.<com.trendingGrpc.TrendingRequest, com.trendingGrpc.TrendingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.trendingGrpc.TrendingService", "getTop10Movies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.trendingGrpc.TrendingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.trendingGrpc.TrendingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TrendingServiceMethodDescriptorSupplier("getTop10Movies"))
                  .build();
          }
        }
     }
     return getGetTop10MoviesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrendingServiceStub newStub(io.grpc.Channel channel) {
    return new TrendingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrendingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TrendingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrendingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TrendingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TrendingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getTop10Movies(com.trendingGrpc.TrendingRequest request,
        io.grpc.stub.StreamObserver<com.trendingGrpc.TrendingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTop10MoviesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTop10MoviesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.trendingGrpc.TrendingRequest,
                com.trendingGrpc.TrendingResponse>(
                  this, METHODID_GET_TOP10MOVIES)))
          .build();
    }
  }

  /**
   */
  public static final class TrendingServiceStub extends io.grpc.stub.AbstractStub<TrendingServiceStub> {
    private TrendingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrendingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrendingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrendingServiceStub(channel, callOptions);
    }

    /**
     */
    public void getTop10Movies(com.trendingGrpc.TrendingRequest request,
        io.grpc.stub.StreamObserver<com.trendingGrpc.TrendingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTop10MoviesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TrendingServiceBlockingStub extends io.grpc.stub.AbstractStub<TrendingServiceBlockingStub> {
    private TrendingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrendingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrendingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrendingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.trendingGrpc.TrendingResponse getTop10Movies(com.trendingGrpc.TrendingRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTop10MoviesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TrendingServiceFutureStub extends io.grpc.stub.AbstractStub<TrendingServiceFutureStub> {
    private TrendingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrendingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrendingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrendingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.trendingGrpc.TrendingResponse> getTop10Movies(
        com.trendingGrpc.TrendingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTop10MoviesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TOP10MOVIES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TrendingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TrendingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TOP10MOVIES:
          serviceImpl.getTop10Movies((com.trendingGrpc.TrendingRequest) request,
              (io.grpc.stub.StreamObserver<com.trendingGrpc.TrendingResponse>) responseObserver);
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

  private static abstract class TrendingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrendingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.trendingGrpc.TrendingServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrendingService");
    }
  }

  private static final class TrendingServiceFileDescriptorSupplier
      extends TrendingServiceBaseDescriptorSupplier {
    TrendingServiceFileDescriptorSupplier() {}
  }

  private static final class TrendingServiceMethodDescriptorSupplier
      extends TrendingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TrendingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TrendingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrendingServiceFileDescriptorSupplier())
              .addMethod(getGetTop10MoviesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
