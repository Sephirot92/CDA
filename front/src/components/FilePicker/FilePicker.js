import { useState } from "react";
import * as Styled from "./FilePicker.styled";
import { AiFillFileAdd } from "react-icons/ai";

const FilePicker = ({ id }) => {
  const [selectedFile, setFile] = useState(null);

  const handleFile = (e) => {
    if (e.target.files) {
      setFile(e.target.files[0]);
    }
  };

  return (
    <Styled.Wrapper htmlFor={id}>
      <Styled.Title>
        {selectedFile !== null ? selectedFile.name : "Miejsce na plik"}
      </Styled.Title>
      <Styled.Input
        onChange={handleFile}
        id={id}
        name={id}
        type="file"
        accept=".xls, .xlsx"
      />
      <Styled.Icon
        width="64"
        height="64"
        viewBox="0 0 64 64"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M16 8C16 3.5875 19.5875 0 24 0H44V16C44 18.2125 45.7875 20 48 20H64V56C64 60.4125 60.4125 64 56 64H24C19.5875 64 16 60.4125 16 56V42H37.7625L32.8875 46.875C31.7125 48.05 31.7125 49.95 32.8875 51.1125C34.0625 52.275 35.9625 52.2875 37.125 51.1125L47.125 41.1125C48.3 39.9375 48.3 38.0375 47.125 36.875L37.125 26.875C35.95 25.7 34.05 25.7 32.8875 26.875C31.725 28.05 31.7125 29.95 32.8875 31.1125L37.7625 35.9875H16V8ZM16 36V42H3C1.3375 42 0 40.6625 0 39C0 37.3375 1.3375 36 3 36H16ZM64 16H48V0L64 16Z"
          fill="#008080"
        />
      </Styled.Icon>
    </Styled.Wrapper>
  );
};

export default FilePicker;
