import styled from "styled-components";

const Wrapper = styled.section`
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 40px;
  padding: 96px 0;
  max-width: 1040px;
  margin: 0 auto;
`;

const Header = styled.header`
  display: flex;
  width: 100%;
  justify-content: space-evenly;
  align-items: center;
`;

const Title = styled.h1`
  font-size: 51px;
  line-height: 76px;
  color: #004d4d;
  font-family: "PoppinsLight";
  margin: 0;
`;

const List = styled.ul`
  list-style: none;
  display: flex;
  padding: 0;
  align-items: stretch;
  gap: 16px;
  font-weight: 300;
`;

export { Header, Title, Wrapper, List };
