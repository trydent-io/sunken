module sunken.webapp {
  opens io.sunken;

  requires java.sql;

  requires org.slf4j;

  requires vertx.core;
  requires vertx.web;

  requires gson;
}
