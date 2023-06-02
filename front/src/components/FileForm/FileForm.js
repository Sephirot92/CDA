import * as Styled from "./FileForm.styled";
import FilePicker from "../FilePicker";
import Button from "../Button";

const FileForm = ({ changeStatus }) => {
  const handleSubmit = async (e) => {
    e.preventDefault();

    const fileInput = e.target.elements[0];

    const formData = new FormData();

    if (fileInput.files.length) {
      try {
        const file = fileInput.files[0];

        formData.append("document", file);

        const response = await fetch(
          "http://localhost:8080/xlsLoader/v1/uploadCompanyDataFile",
          {
            method: "post",
            "Content-Type": "multipart/form-data",
            body: formData,
            "Access-Control-Allow-Origin": "*",
          }
        );

        if (response.ok && response.status >= 200 && response.status < 300) {
          const data = await response.json();
          changeStatus("success", data);
        } else {
          changeStatus("error");
        }
      } catch (err) {
        console.error(err);
      }
    }
  };

  return (
    <Styled.Wrapper>
      <Styled.Header>
        <Styled.Title>Witaj Szanowny Panie Kierowniku <br />w programie do premii 	&#59;&#41;</Styled.Title>
      </Styled.Header>
      <Styled.Form onSubmit={handleSubmit}>
        <FilePicker />
        <Button type="submit" title="Generuj" />
      </Styled.Form>
    </Styled.Wrapper>
  );
};

export default FileForm;
