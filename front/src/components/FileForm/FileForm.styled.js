import styled from "styled-components";

const Wrapper = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 48px;
  padding: 96px 16px;
`;

const Header = styled.header`
  display: flex;
  justify-content: space-evenly;
  align-items: center;
`;

const Title = styled.h1`
  font-size: 51px;
  line-height: 76px;
  color: #004d4d;
  font-family: "PoppinsExtraLight";
  text-align: center;
  margin: 0;
`;

const Form = styled.form`
  width: 100%;
  max-width: 560px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  gap: 64px;

  @media screen and (max-width: 786px) {
    padding: 32px 8px;
  }

  @media screen and (min-width: 787px) {
    padding: 64px 16px;
  }
`;

export { Wrapper, Form, Header, Title };
