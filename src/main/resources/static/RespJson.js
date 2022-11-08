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
let a = document.getElementById('a');
//let file = document.getElementById('formFile');


a.insertAdjacentHTML('afterend',"<h2 id = 'b'>" + subscrId + "</h2>")
let b = document.getElementById('b');

a.insertAdjacentHTML('afterend',"<button type='submit' onclick='call()'>Перезапустить</button>")

b.insertAdjacentHTML('afterend',"<button type='submit' onclick='refreshData()'>Обновить</button>")
b.insertAdjacentHTML('afterend',"<h2 id = 'c'>" + valueArr[0] + "</h2>")
let c = document.getElementById('c');
c.insertAdjacentHTML('afterend',"<h2 id = 'd'>" + valueArr[1] + "</h2>")
let d = document.getElementById('d');



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
   // console.log(session)
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
    await postRefreshData('http://127.0.0.1:8043/Methods/RefreshData', {'sessionId': session, "subscriptionId":subscrId})
    //console.log("seq " + sequenceNumberID);
    await postPublishData('http://127.0.0.1:8043/Methods/PublishData', {'sessionId': session, "subscriptionId":subscrId, "ackSequenceNumber":sequenceNumberID})
    c.innerHTML = "<h2>" + valueArr[0] + "</h2>";
    d.innerHTML = "<h2>" + valueArr[1] + "</h2>";
}