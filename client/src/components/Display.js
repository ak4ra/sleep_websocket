import React, { useState } from "react";
import DisplayItem from "./DisplayItem";

export default function Display({ socket }) {
  const [infoQueue, setInfoQueue] = useState([]);

  function insertInfoItem(item) {
    setInfoQueue(infoQueue => [...infoQueue, item]);
    setTimeout(() => {
      setInfoQueue(infoQueue => {
        return infoQueue.slice(1);
      });
    }, 11000);
  }

  socket.onmessage = function(data) {
    insertInfoItem(data.data);
  };

  return (
    <div className="display">
      {infoQueue.map((item, index) => {
        return <DisplayItem key={index} item={item} className="display_item" />;
      })}
    </div>
  );
}
