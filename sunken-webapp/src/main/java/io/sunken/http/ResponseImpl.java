package io.sunken.http;

import io.undertow.server.HttpServerExchange;

import static java.lang.System.arraycopy;

final class ResponseImpl implements Response {
  private final StatusCode code;
  private final Header[] headers;

  ResponseImpl(final StatusCode code) {
    this(code, new Header[0]);
  }

  private ResponseImpl(final StatusCode code, Header[] headers) {
    this.code = code;
    this.headers = headers;
  }

  @Override
  public boolean is(final StatusCode code) {
    return this.code == code;
  }

  @Override
  public boolean has(final String header) {
    boolean has = headers.length > 0 && headers[0].entry().equals(header);
    for (int index = 1; !has && index < headers.length; index++) {
      has = headers[index].entry().equals(header);
    }
    return has;
  }

  @Override
  public Response header(String entry, String value) {
    final Header[] nh = new Header[headers.length + 1];
    arraycopy(headers, 0, nh, 0, headers.length);
    nh[headers.length] = Header.of(entry, value);
    return new ResponseImpl(code, nh);
  }

  @Override
  public <P extends ResponseExchange> HttpServerExchange apply(P projection) {
    return projection.get();
  }
}
