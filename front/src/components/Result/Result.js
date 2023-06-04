import Button from "../Button";
import StarIcon from "../StarIcon";
import Tile from "../Tile";
import * as Styled from "./Result.styled";

const Result = ({ data, changeStatus }) => {
  if (!data || !data.length) {
    return (
      <Styled.Wrapper>
        <h1>No data to display</h1>
      </Styled.Wrapper>
    );
  }

  return (
    <Styled.Wrapper>
      <Styled.Header>
        <StarIcon />
        <Styled.Title>Propozycje</Styled.Title>
        <StarIcon />
      </Styled.Header>
      <Styled.List>
        {data.map((el, idx) => (
          <Tile key={idx} element={el} idx={idx} />
        ))}
      </Styled.List>
      <Button type='button' title="Ponów" onClick={() => changeStatus("initial", [])} />
    </Styled.Wrapper>
  );
};

export default Result;
