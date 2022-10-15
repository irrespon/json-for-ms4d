session = 0;
subscrId = 0;

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
    console.log(session)
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
    console.log(subscrId);
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

    console.log(dat);
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

    console.log(dat);
}

call()

async function call() {
    console.log(session)
    if(session == 0) {
        await postLogin('http://127.0.0.1:8043/Methods/Login', {});
    }
    let a = document.getElementById('a');
    a.insertAdjacentHTML('afterend',"<h2>" + session + "</h2>")
    //a.innerHTML = "<h2>" + session + "</h2>";

    await postCreateDataSub('http://127.0.0.1:8043/Methods/CreateDataSubscription', {'sessionId': session})

    await postCreateMonDI('http://127.0.0.1:8043/Methods/CreateMonitoredDataItems', {'sessionId': session, "subscriptionId":subscrId, "items":[{ "itemId":74474}]})

    await postPublishData('http://127.0.0.1:8043/Methods/PublishData', {'sessionId': session, "subscriptionId":subscrId})
}