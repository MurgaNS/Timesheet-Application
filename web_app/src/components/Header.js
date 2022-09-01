import React from "react";
import classes from "./NavHeaderCss.module.css";
import logo from "../images/logo/logo-white.png";
import { Link } from "react-router-dom";
import Navigation from "../components/Navigation";
import User from "./User";

function Header() {
  return (
    <div className={classes.container}>
      <header className={classes.header}>
        <div className={classes["inner-wrap"]}>
          <Link to="/index" className={classes.logo}>
            <img src={logo} />
          </Link>
          <Navigation></Navigation>
          <User />
        </div>
      </header>
    </div>
  );
}

export default Header;
