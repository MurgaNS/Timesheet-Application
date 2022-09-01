import classes from "../NavHeaderCss.module.css";

function AlphabetItem(props) {
  const clickHandler = () => {
    props.getLetter(props.letter);
  };

  return (
    <li className={classes.alphabet__list}>
      <button onClick={clickHandler} className={classes.alphabet__button}>
        {props.letter}
      </button>
    </li>
  );
}

export default AlphabetItem;
