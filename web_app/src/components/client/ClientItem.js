import classes from "../NavHeaderCss.module.css";
import React, { useRef } from "react";
import { useState, useMemo } from "react";
import axios from "axios";
import Select from "react-select";
import countryList from "react-select-country-list";

const ClientItem = (props) => {

  const options = useMemo(() => countryList().getData(), []);
  const inputNameRef = useRef();
  const inputAddressRef = useRef();
  const inputCityRef = useRef();
  const inputPostalCodeRef = useRef();
  const [country, setCountry] = useState("");

  const [showClient, setShowClient] = useState(false);

  const showClientHandler = () => {
    setShowClient((prevState) => !prevState);
  };

  const changeHandler = (country) => {
    setCountry(country);
  };

  const clientDelete = (e) => {
    e.preventDefault();
    axios
      .delete(`http://localhost:8080/api/v1/clients/${props.id}`)
      .then((res) => console.log("Deleted!", res))
      .catch((err) => console.log(err));

    props.onDelete(props.id);
  };

  const updateClient = (e) => {
    e.preventDefault();

    axios
      .put(`http://localhost:8080/api/v1/clients/${props.id}`, {
        name: inputNameRef.current.value,
        address: inputAddressRef.current.value,
        city: inputCityRef.current.value,
        postalCode: inputPostalCodeRef.current.value,
        country: {
          name: country.label,
          countryCode: country.value,
        },
        version: props.client.version,
      })
      .then((res) => console.log("Changed!", res))
      .catch((err) => console.log(err));
  };
  return (
    <div className={classes.accordion}>
    <div className={classes.accordion__intro} onClick={showClientHandler}>
      <h4 className={classes.accordion__title} id="name">
        {props.client.name}
      </h4>
    </div>
    <form
      onSubmit={updateClient}
      className={classes.accordion__content}
      style={{ display: showClient ? "block" : "none" }}
    >
      <div className={classes.info}>
        <div className={classes.info__form}>
          <ul className={classes.info__wrapper}>
            <li className={classes.info__list}>
              <label className={classes.info__label}>Client name:</label>
              <input
                type="text"
                className={`${classes["in-text"]}`}
                ref={inputNameRef}
                defaultValue={props.client.name}
              />
            </li>
            <li className={classes.info__list}>
              <label className={classes.report_label}>Address:</label>
              <input
                type="text"
                className={`${classes["in-text"]}`}
                ref={inputAddressRef}
                defaultValue={props.client.address}
              />
            </li>
            <li className={classes.info__list}>
              <label className={classes.report_label}>City:</label>
              <input
                type="text"
                className={`${classes["in-text"]}`}
                ref={inputCityRef}
                defaultValue={props.client.city}
              />
            </li>
            <li className={classes.info__list}>
              <label className={classes.report_label}>Zip/Postal code:</label>
              <input
                type="text"
                className={`${classes["in-text"]}`}
                ref={inputPostalCodeRef}
                defaultValue={props.client.postalCode}
              />
            </li>
            <li className={classes.info__list}>
              <label className={classes.report_label}>Country:</label>
              <Select
                options={options}
                onChange={changeHandler}
                defaultValue={{
                  label: props.client.country.name,
                  value: props.client.country.countryCode,
                }}
              ></Select>
            </li>
          </ul>
        </div>
      </div>
      <div className={`${classes["btn-wrap"]}`}>
        <button
          type="submit"
          className={`${classes["btn"]} ${classes["btn--green"]} `}
        >
          <span>Save changes</span>
        </button>
        <button
          type="button"
          className={`${classes["btn"]} ${classes["btn--red"]}`}
          onClick={clientDelete}
        >
          <span>Delete</span>
        </button>
      </div>
    </form>
  </div>
  );
};
export default ClientItem;
