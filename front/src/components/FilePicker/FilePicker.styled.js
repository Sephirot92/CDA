import styled from "styled-components";

const Wrapper = styled.label`
  position: relative;
  border-radius: 8px;
  border: 4px solid #008080;
  padding: 0;
  background-color: #fff;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  cursor: pointer;
`;

const Input = styled.input`
  position: absolute;
  top: 0;
  left: 0;
  width: 1px;
  height: 1px;
  opacity: 0;
`;

const Title = styled.p`
  font-size: 28px;
  line-height: 42px;
  width: 100%;
  text-align: center;
  margin: 0;
  background-color: #008080;
  color: #ffffff;
  padding: 8px 0;
`;

const Icon = styled.svg`
  margin: 32px 0 40px;
`;

export { Wrapper, Input, Title, Icon };
