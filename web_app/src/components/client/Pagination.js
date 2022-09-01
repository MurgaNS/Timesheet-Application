import classes from "../NavHeaderCss.module.css";

function Pagination({clientsPerPage, totalClients, paginate}) {
  const pageNumbers = [];
  
  for (let i = 1; i <= Math.ceil(totalClients / clientsPerPage); i++) {
    pageNumbers.push(i);
  }
  return (
  
    <div className={classes.pagination}>
      <ul className={classes.pagination__navigation}>
        <li className={classes.pagination__list}>
          <a className={classes.pagination__button}>Previous</a>
        </li>

        {pageNumbers.map((number) => (
          <li className={classes.pagination__list} key={number}>
            <a
              className={`${classes["pagination__button--active"]} ${classes["pagination__button"]} `}
              onClick={() => paginate(number)}
            >
              {number}
            </a>
          </li>
        ))}

        <li className={classes.pagination__list}>
          <a className={classes.pagination__button}>Next</a>
        </li>
      </ul>
    </div>
  );
}
export default Pagination;
