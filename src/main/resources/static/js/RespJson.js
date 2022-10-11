sessionId = 0;
subscrId = 0;

async function postLogin(url = '', data = {}) {
    let response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });
   const dat = await response.json()
    sessionId = dat.sessionId;
    console.log(sessionId)
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
    await postLogin('http://127.0.0.1:8043/Methods/Login', {})

    await postCreateDataSub('http://127.0.0.1:8043/Methods/CreateDataSubscription', {'sessionId': sessionId})

    await postCreateMonDI('http://127.0.0.1:8043/Methods/CreateMonitoredDataItems', {'sessionId': sessionId, "subscriptionId":subscrId, "items":[{ "itemId":74474}]})

    await postPublishData('http://127.0.0.1:8043/Methods/PublishData', {'sessionId': sessionId, "subscriptionId":subscrId})
}