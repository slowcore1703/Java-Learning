function sendData(){
  const text = document.getElementById('userInput').value;

  const dataToSend = {
    message: text,
    timestamp: new Date().toLocaleTimeString(),
    sender: "FrontEnd"
  }

  const jsonString = JSON.stringify(dataToSend);

  console.log("Подготовлено к отправке: ", jsonString);

  const blob = new Blob([jsonString], {type: "application/json"});
  const url = URL.createObjectURL(blob);
  const a = document.createElement("a");

  a.href = url;
  a.download = "back.json";
  a.click();
  
  document.getElementById('statusLabel').innerText = "Данные упакованы в JSON";
}