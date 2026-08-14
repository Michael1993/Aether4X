module aether.ui {
  requires aether.api;
  requires aether.domain;
  requires javafx.graphics;
  requires java.sql;
  requires com.h2database;

  exports com.aether.ui.drawers;

  uses com.aether.ui.event.NodeBasedEventHandler;

  provides com.aether.ui.event.NodeBasedEventHandler with
          com.aether.ui.event.MapDragHandler,
          com.aether.ui.event.MapZoomHandler,
          com.aether.ui.event.MapZoomResetHandler;

}
