import classes from "../NavHeaderCss.module.css";
import React, { useRef } from "react";
import Modal from "./Modal";
import {useState} from "react";

function CreateClient(props) {

  const [modal, setModal] = useState(false);

  const inputRef = useRef();

  const submitHandler = (event) => {
    event.preventDefault();
    props.getName(inputRef.current.value);
  };

  const showModalHandler = () => {
    setModal(true);
  };

  const closeModalHandler = () => {
    setModal(false);
  };

  return (
    <div className={classes["table-navigation"]}>
      <button className={`${classes["table-navigation__create"]} ${classes['btn-modal']}}`} onClick={showModalHandler}>Add new client</button>
      <div className={` ${classes.modal} ${modal ? `${classes['modal--show']}`: ''}`}>
        <Modal onAdd={props.onAdd} onClose={closeModalHandler}></Modal>
      </div>

      <form className={`${classes["table-navigation__input-container"]}`} onSubmit={submitHandler}>
        <input
          type="text"
          className={`${classes["table-navigation__input-container"]}`}
          ref={inputRef}
          
        />
        <button type="submit" className={classes.icon__search}></button>
      </form>
    </div>
  );
}

export default CreateClient;
