import styled from "styled-components";

const Wrapper = styled.li`
  flex-basis: calc(100% / 3);
  border: 4px solid #008080;
  border-radius: 16px;
`;

const Header = styled.header`
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  width: 100%;
  text-align: center;
  margin: 0;
  background-color: #008080;
  color: #ffffff;
  padding: 8px 0;
  border-radius: 8px 8px 0 0;
`;

const Title = styled.h1`
  font-size: 28px;
  line-height: 42px;
  color: #ffffff;
  font-family: "PoppinsLight";
  text-align: center;
  margin: 0;
`;

const Content = styled.div`
  padding: 16px;
`;

export { Wrapper, Header, Content, Title };
