import styled from "styled-components";

const Wrapper = styled.div`
  @media screen and (max-width: 786px) {
    margin: 32px 0;
  }

  @media screen and (min-width: 787px) {
    margin: 64px 0;
    border-radius: 32px;
    max-width: 1280px;
    background-color: white;
    box-shadow: 0 0 16px #ccc;
    min-height: 700px;
    margin: 96px auto;
  }
`;

export { Wrapper };
