import * as Styled from "./Tile.styled";

const Tile = ({ element, idx }) => {
  return (
    <Styled.Wrapper>
      <Styled.Header>
        <Styled.Title>Opcja {idx}</Styled.Title>
      </Styled.Header>
      <Styled.Content>
        {Object.entries(element).map(([key, value]) => (<p key={key}>{key}: {value}</p>))}
      </Styled.Content>
    </Styled.Wrapper>
  );
};

export default Tile;
