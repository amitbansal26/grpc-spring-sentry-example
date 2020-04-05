package com.something.example.spring.grpc.sentry.adapter.interceptor;

import com.something.example.spring.grpc.sentry.adapter.sentry.ExtraInfoCollector;
import io.grpc.*;
import io.sentry.Sentry;
import io.sentry.SentryClient;
import org.lognet.springboot.grpc.GRpcGlobalInterceptor;

@GRpcGlobalInterceptor
public class SentryGrpcErrorInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
                                                                 Metadata headers,
                                                                 ServerCallHandler<ReqT, RespT> next) {
        var reqTListener = next.startCall(call, headers);
        return new SentryGprcExceptionListener<>(reqTListener, call, headers);
    }


    private class SentryGprcExceptionListener<ReqT,RespT>
            extends ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT> {

        private ServerCall<ReqT, RespT> serverCall;
        private Metadata metadata;
        private ExtraInfoCollector extraInfoCollector;

        public SentryGprcExceptionListener(ServerCall.Listener<ReqT> delegate,
                                           ServerCall<ReqT, RespT> call,
                                           Metadata headers) {
            super(delegate);
            SentryClient sentryClient = Sentry.getStoredClient();
            if (sentryClient != null) {
                this.extraInfoCollector = new ExtraInfoCollector(sentryClient);
            }
            this.serverCall = call;
            this.metadata = headers;
            extraInfoCollector.recordMetadata(headers);
            extraInfoCollector.recordCallData(call);

        }

        @Override
        public void onMessage(ReqT message) {
            try {
                extraInfoCollector.recordMessage(message);
                super.onMessage(message);
            } catch (Exception e) {
                logException(e);
                throw e;
            }
        }

        @Override
        public void onCancel() {
            try {
                super.onCancel();
            } catch (Exception e) {
                logException(e);
                throw e;
            }
        }

        @Override
        public void onComplete() {
            try {
                super.onComplete();
            } catch (Exception e) {
                logException(e);
                throw e;
            }
        }

        @Override
        public void onHalfClose() {
            try {
                super.onHalfClose();
            } catch (Exception e) {
                logException(e);
                throw e;
            }
        }

        @Override
        public void onReady() {
            try {
                super.onReady();
            } catch (Exception e) {
                logException(e);
                throw e;
            }
        }

        private void logException(Exception ex) {
            extraInfoCollector.recordContext(Context.current());
            SentryClient sentryClient = Sentry.getStoredClient();
            if (sentryClient != null) {
                sentryClient.sendException(ex);
                sentryClient.clearContext();
            }
        }
    }
}
