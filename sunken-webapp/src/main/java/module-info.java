module sunken.webapp {
  opens io.sunken;

  requires java.sql;
  requires java.json;
  requires java.json.bind;

  requires org.slf4j;

  requires undertow.core;
}
