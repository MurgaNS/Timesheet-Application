import classes from "./NavHeaderCss.module.css";
import { Link } from "react-router-dom";

function User() {
  return (
    <div className={classes.user}>
      <div className={classes.user__nav}>
        <h2 className={classes.user__name}>Ognjen Adamović</h2>
        <ul className={classes.user__dropdown}>
          <li className={classes.user__list}>
            <Link className={classes.user__link} to="/change-password">
              {" "}
              Change password
            </Link>
          </li>
          <li className={classes.user__list}>
            <Link className={classes.user__link} to="/settings">
              {" "}
              Settings
            </Link>
          </li>
          <li className={classes.user__list}>
            <Link className={classes.user__link} to="/export-data">
              {" "}
              Export all data
            </Link>
          </li>
        </ul>
      </div>
      <ul>
        <li className={classes.logout}>
          <a className={classes.logout__link} />
          Logout
        </li>
      </ul>
    </div>
  );
}

export default User;
