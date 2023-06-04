import * as Styled from "./Button.styled";

const Button = ({ title, type='button', onClick }) => {
  return <Styled.Button onClick={onClick} type={type}>{title}</Styled.Button>;
};

export default Button;
