import React, { Component } from "react";

class ToDoItem extends Component {
  render() {
    return (
      <div style = {{cursor:"pointer"}}
      onClick={() => {
        this.props.onChecked(this.props.id);
      }}
    >
      <li>{this.props.text}</li>
    </div>
    );
  }
}

export default ToDoItem;
