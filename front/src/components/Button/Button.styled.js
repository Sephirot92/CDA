import styled from "styled-components";

const Button = styled.button`
  border-radius: 16px;
  border: 4px solid #008080;
  background-color: white;
  color: #008080;
  cursor: pointer;
  font-family: PoppinsMedium;
  align-self: flex-end;
  font-size: 28px;
  line-height: 42px;
  padding: 4px 40px;
  transition-property: background-color, color;
  transition-duration: .3s;
  transition-timing-function: ease-in-out;

  &:active {
    background-color: #008080;
    color: #ffffff;
  }
`;

export { Button };
