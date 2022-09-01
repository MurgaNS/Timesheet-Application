import classes from "../NavHeaderCss.module.css";
import React from "react";
import AlphabetItem from "./AlphabetItem";

const ALPHABET = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];

function Alphabet(props) {
  return (
    <div className={classes.alphabet}>
      <ul className={classes.alphabet__navigation}>
        {ALPHABET.map(letter => <AlphabetItem getLetter={props.getLetter1} key={letter} letter={letter}/>)}
      </ul>
    </div>
  );
}

export default Alphabet;
