import React, { useState } from "react";
import useWebSocket from "./lib/useWebSocket";
import "./App.css";

import Display from "./components/Display";

function App() {
  const socket = useWebSocket();

  return (
    <div className="main">
      <Display socket={socket} />
    </div>
  );
}

export default App;
