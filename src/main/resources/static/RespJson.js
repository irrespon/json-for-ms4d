let session = 0;
let subscrId = 0;
let sequenceNumberID = 0;
let publishDataMS4D = {
    code:0,
    haseMore: false,
    recs: [{
        0:{clientHandle:0, value:0},
        1:{clientHandle:1, value:0}
    }],
    sequenceNumber:0
}
let valueArr = [0,false];
let file = document.getElementById('formFile');
let nameFile = '';

createFormFile()

call();
//let timeInterval = setInterval(refreshData,1000);

async function postLogin(url = '', data = {}) {
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });
   const dat = await response.json();
    session = dat.sessionId;
   // console.log(session)
}

async function postCreateDataSub(url = '', data = {}) {
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });
    const dat =  await response.json();
    subscrId = dat.subscriptionId;
   // console.log(subscrId);
}

async function postCreateMonDI(url = '', data = {}) {
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });
    const dat =  await response.json();

    //console.log(dat);
}

async function postPublishData(url = '', data = {}) {
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });
    const dat =  await response.json();
publishDataMS4D = dat;
if(typeof publishDataMS4D.sequenceNumber !== 'undefined') {
    sequenceNumberID = publishDataMS4D.sequenceNumber;
    let i = 0;

    while (i < publishDataMS4D.recs.length){
       valueArr[i]  = publishDataMS4D.recs[i].value;
       i++;
    }
    // value1 = publishDataMS4D.recs[0].value
    // value2 = publishDataMS4D.recs[1].value
}

     console.log(dat);
    // console.log(publishDataMS4D);
    // console.log("sequence" + sequenceNumberID);
    // console.log("value" + publishDataMS4D.recs[0].value);
}

async function postRefreshData(url = '', data = {}) {
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });
    const dat =  await response.json();
    console.log(dat);
}


async function call() {
    let a = document.getElementById('a');
    let b = document.getElementById('b');
    let c = document.getElementById('c');
    let d = document.getElementById('d');

    if(session == 0) {
        await postLogin('http://127.0.0.1:8043/Methods/Login', {});
    }

    a.innerHTML = "<h2>" + session + "</h2>";

    await postCreateDataSub('http://127.0.0.1:8043/Methods/CreateDataSubscription', {'sessionId': session})

    b.innerHTML = "<h2>" + subscrId + "</h2>";

    await postCreateMonDI('http://127.0.0.1:8043/Methods/CreateMonitoredDataItems', {'sessionId': session, "subscriptionId":subscrId, "items":[{ clientHandle:0,"itemId":80034},{clientHandle:1,"itemId":74204}]})
    await postPublishData('http://127.0.0.1:8043/Methods/PublishData', {'sessionId': session, "subscriptionId":subscrId})
    c.innerHTML = "<h2>" + valueArr[0] + "</h2>";
    d.innerHTML = "<h2>" + valueArr[1] + "</h2>";

}

async function refreshData(){
    let c = document.getElementById('c');
    let d = document.getElementById('d');

    await postRefreshData('http://127.0.0.1:8043/Methods/RefreshData', {'sessionId': session, "subscriptionId":subscrId})
    //console.log("seq " + sequenceNumberID);
    await postPublishData('http://127.0.0.1:8043/Methods/PublishData', {'sessionId': session, "subscriptionId":subscrId, "ackSequenceNumber":sequenceNumberID})
    c.innerHTML = "<h2>" + valueArr[0] + "</h2>";
    d.innerHTML = "<h2>" + valueArr[1] + "</h2>";
}

async function upload(){
    let alertMessageUploadFile = document.getElementById('alertMessageUploadFile')
    let formData = new FormData();
    formData.append("file",formFile.files[0]);
    let respon = await fetch('/upload',{
        method:'POST',
        body: formData
    })
    let result = respon.text();
    if(respon.status === 200){
        alertMessageUploadFile.className = 'alert alert-success';
        alertMessageUploadFile.innerHTML = 'Файл ' + (await result).toString() + ' загружен';
        nameFile = (await result).toString();
    } else {
        alertMessageUploadFile.innerHTML = "<lable class='alert alert-danger' role='alert'>Ошибка, файл не загружен</lable>";
        nameFile = "";
    }
    console.log(nameFile);
}

async function creatUploadFileForm(){
    let uploadFileForm = document.getElementById('uploadFileForm');
    await uploadFileForm.insertAdjacentHTML('afterend',"<div class='mb-3' id = 'loadFileForm'>" +
        "<label for='formFile' class='form-label'>2.</label></br>" +
        "<button class='btn btn-outline-secondary' type='button' onclick='upload()'>Загрузить файл</button>" +
        "<lable class='alert alert-secondary' role='alert' id='alertMessageUploadFile'>Файл не загружен</lable>" +
        "</div>")
}

async function creatLoadFileForm(){
    let loadFileForm = document.getElementById('loadFileForm');
    await loadFileForm.insertAdjacentHTML('afterend',"<div class='mb-3' id = 'loadFileForm'>" +
        "<label for='formFile' class='form-label'>3.</label></br>" +
        "<button class='btn btn-outline-secondary' type='button' onclick='loadFile()'>Прочитать файл</button>" +
        "<lable class='alert alert-secondary' role='alert' id='alertMessageReadFile'>Файл не прочитан</lable>" +
        "</div>")
}

async function loadFile(){
    let alertMessageReadFile = document.getElementById('alertMessageReadFile')
    let respon = await fetch('/loadFile',{
        method:'POST',
        body:nameFile
    })
    let result = respon;
    if(respon.status === 200){
        alertMessageReadFile.className = 'alert alert-success';
        alertMessageReadFile.innerHTML = 'Файл ' + nameFile + ' прочитан';
    } else {
        alertMessageReadFile.innerHTML = "<lable class='alert alert-danger' role='alert'>Ошибка, файл не прочитан</lable>";
        nameFile = "";
    }
    //console.log(result)
}

async function createFormFileA(){
    let a = document.getElementById('a');
    await a.insertAdjacentHTML('afterend',"<h2 id = 'b'>" + 'номер сессии ' + subscrId + "</h2>")
    await a.insertAdjacentHTML('afterend',"<button type='submit' onclick='call()'>Перезапустить</button>")
}

async function createFormFileB(){
    let b = document.getElementById('b');
    b.insertAdjacentHTML('afterend',"<h2 id = 'c'>" + valueArr[0] + "</h2>")
    b.insertAdjacentHTML('afterend',"<button type='submit' onclick='refreshData()'>Обновить</button>")
}

async function createFormFileC(){
    let c = document.getElementById('c');
    c.insertAdjacentHTML('afterend',"<h2 id = 'd'>" + valueArr[1] + "</h2>")
}

async function createFormFile(){
   await creatUploadFileForm();
   await creatLoadFileForm();
    await createFormFileA();
    await createFormFileB();
    await createFormFileC();
}

