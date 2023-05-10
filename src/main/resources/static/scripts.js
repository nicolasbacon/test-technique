const refreshButton = document.getElementById('refresh-button');
const formationsTable = document.getElementById('formations-table');

refreshButton.addEventListener('click', () => {
  const xhr = new XMLHttpRequest();
  xhr.onreadystatechange = () => {
    if (xhr.readyState === 4 && xhr.status === 200) {
        console.log(xhr.response);
      const newTableBody = xhr.responseText;
      formationsTable.innerHTML = newTableBody;
    }
  };
  xhr.open('GET', '/refresh-formations', true);
  xhr.send();
});
