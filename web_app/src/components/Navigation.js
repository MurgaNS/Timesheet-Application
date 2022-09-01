import React from "react";
import classes from "./NavHeaderCss.module.css";
import { Link } from "react-router-dom";

function Navigation() {
  return (
    <nav className={classes.navigation}>
      <button
        id="navigation__link"
        type="button"
        className={classes.navigation__link}
      >
        <span id="navigation__text" className={classes.navToggle}></span>
      </button>
      <ul className={classes.navigation__menu}>
        <li className={classes.navigation__list}>
          <Link
            to="/index"
            className={`${classes.btn} ${classes.navigation__button} navigation__button--active`}
          >
            Timesheet
          </Link>
        </li>
        <li className={classes.navigation__list}>
          <Link
            to="/clients"
            className={`${classes.btn} ${classes.navigation__button}`}
          >
            Clients
          </Link>
        </li>
        <li className={classes.navigation__list}>
          <Link
            to="/projects"
            className={`${classes.btn} ${classes.navigation__button}`}
          >
            Projects
          </Link>
        </li>
        <li className={classes.navigation__list}>
          <Link
            to="/categories"
            className={`${classes.btn} ${classes.navigation__button}`}
          >
            Categories
          </Link>
        </li>
        <li className={classes.navigation__list}>
          <Link
            to="/employees"
            className={`${classes.btn} ${classes.navigation__button}`}
          >
            Employees
          </Link>
        </li>
        <li className={classes.navigation__list}>
          <Link
            to="/reports"
            className={`${classes.btn} ${classes.navigation__button}`}
          >
            Reports
          </Link>
        </li>
      </ul>
    </nav>
  );
}

export default Navigation;
