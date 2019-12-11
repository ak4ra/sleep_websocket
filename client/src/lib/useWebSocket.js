export default function useWebSocket() {
  // for development
  // const socket = new WebSocket("ws://localhost:8080/updates");
  // for production
  const socket = new WebSocket(`wss://${window.location.host}/updates`);

  socket.onopen = function() {
    console.log("websocket connected");
  };

  socket.onclose = function() {
    console.log("websocket closed");
  };

  return socket;
}
