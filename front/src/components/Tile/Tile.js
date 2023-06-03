import * as Styled from "./Tile.styled";

const Tile = ({ element, idx }) => {
  const translations = {
    projectName: "Nazwa projektu",
    projectEarnings: "Zysk Projektu / os. $",
    numberOfEmployees: "Liczba pracowników",
    clientScore: "Ocena klientów",
    slaValue: "Wartość SLA %",
    innerScore: "Ocena wewnętrzna",
    teamCoverage: "Pokrycie zasobów %",
    totalProjectScore: "Liczba punktów",
  };

  return (
    <Styled.Wrapper>
      <Styled.Header>
        <Styled.Title>Opcja {idx}</Styled.Title>
      </Styled.Header>
      <Styled.Content>
        {Object.entries(element).map(([key, value]) => (
          <p key={key}>
            {translations[key]}: {value}
          </p>
        ))}
      </Styled.Content>
    </Styled.Wrapper>
  );
};

export default Tile;
