import React from "react";

export default function DisplayItem({ item }) {
  return (
    <div className="display_item">
      <h3>{item}</h3>
    </div>
  );
}
