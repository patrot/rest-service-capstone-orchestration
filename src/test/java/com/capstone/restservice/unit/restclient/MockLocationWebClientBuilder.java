package com.capstone.restservice.unit.restclient;

import com.capstone.restservice.restclient.LocationDto;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockLocationWebClientBuilder {

    private LocationDto[] httpGetBody;

    private String uriPath;

    private WebClient.Builder builderMock;

    private WebClient webClientMock;

    private WebClient.RequestHeadersSpec requestHeadersMock;

    private WebClient.RequestHeadersUriSpec requestHeadersUriMock;

    private WebClient.ResponseSpec responseMock;

    public MockLocationWebClientBuilder() {
        builderMock = mock(WebClient.Builder.class);
        webClientMock = mock(WebClient.class);
        requestHeadersUriMock = mock(WebClient.RequestHeadersUriSpec.class);
        requestHeadersMock = mock(WebClient.RequestHeadersSpec.class);
        responseMock = mock(WebClient.ResponseSpec.class);

        when(builderMock.build()).thenReturn(webClientMock);
        when(webClientMock.get()).thenReturn(requestHeadersUriMock);
    }

    public MockLocationWebClientBuilder setUriPath(String uriPath) {
        this.uriPath = uriPath;
        return this;
    }

    public MockLocationWebClientBuilder setHttpGetBody(LocationDto[] httpGetBody) {
        this.httpGetBody = httpGetBody;
        return this;
    }

    public WebClient.Builder build() {

        when(requestHeadersUriMock.uri(this.uriPath)).thenReturn(requestHeadersMock);
        when(requestHeadersMock.retrieve()).thenReturn(responseMock);

        when(responseMock.bodyToMono(LocationDto[].class)).thenReturn(Mono.just(httpGetBody));

        return builderMock;
    }
}
