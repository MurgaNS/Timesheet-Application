import classes from "../NavHeaderCss.module.css";
import React from "react";
import { useState, useMemo } from "react";
import countryList from "react-select-country-list";
import Select from "react-select";
import clientService from "../../services/clientService";


const Modal = (props) => {
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");
  const [city, setCity] = useState("");
  const [postalCode, setPostalCode] = useState("");
  const [country, setCountry] = useState("");

  const options = useMemo(() => countryList().getData(), []);

  const changeHandler = (country) => {
    setCountry(country);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await clientService.postClient(name, address, city, postalCode, country);
    } catch (error) {
      console.log(error.response);
    }
    props.onClose();
    props.onAdd({ id: Math.random, name, address, city, postalCode, country });
  };

  return (
    <div className={classes.modal__content}>
      <h2 className={classes.heading}>Create new client</h2>
      <a className={classes.modal__close} onClick={props.onClose}>
        <span className={classes.modal__icon}></span>
      </a>
      <form className={classes.info} onSubmit={handleSubmit}>
        <ul className={classes.info__form}>
          <li className={classes.info__list}>
            <label className={classes.info__label}>Client name:</label>
            <input
              type="text"
              className={`${classes["in-text"]}`}
              id="name"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
          </li>
          <li className={classes.info__list}>
            <label className={classes.report__label}>Address:</label>
            <input
              type="text"
              className={`${classes["in-text"]}`}
              id="address"
              value={address}
              onChange={(e) => setAddress(e.target.value)}
            />
          </li>
          <li className={classes.info__list}>
            <label className={classes.info__label}>City:</label>
            <input
              type="text"
              className={`${classes["in-text"]}`}
              id="city"
              value={city}
              onChange={(e) => setCity(e.target.value)}
            />
          </li>
          <li className={classes.info__list}>
            <label className={classes.info__label}>Zip/Postal code:</label>
            <input
              type="text"
              className={`${classes["in-text"]}`}
              id="postalCode"
              value={postalCode}
              onChange={(e) => setPostalCode(e.target.value)}
            />
          </li>
          <li className={classes.info__list}>
            <label className={classes.info__label}>Country:</label>
            <Select
              options={options}
              id="country"
              value={country}
              onChange={changeHandler}
            ></Select>
          </li>
        </ul>
        <div className={`${classes["btn-wrap"]}`}>
          <button
            type="submit"
            className={`${classes["btn"]} ${classes["btn--green"]} `}
          >
            <span>Save changes</span>
          </button>
          <button
            type="button"
            className={`${classes["btn"]} ${classes["btn--red"]} `}
          >
            <span>Delete</span>
          </button>
        </div>
      </form>
    </div>
  );
};

export default Modal;
