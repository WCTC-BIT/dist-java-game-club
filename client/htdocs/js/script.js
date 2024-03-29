document.addEventListener("DOMContentLoaded", () => {
    document.querySelector("#rsvpButton").addEventListener("click", rsvp);
    hideRsvpForm();
    loadEvents();
});


async function rsvp() {
    let id = document.querySelector("#eventId").value;
    let email = document.querySelector("#email").value;

    if (id && id > 0 && email) {
        const url = "http://localhost:8080/api/rsvp";

        const data = {
            eventId: id,
            memberEmail: email
        };

        const requestOptions = {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        };

        fetch(url, requestOptions)
            .then(response => {
                if (response.ok)
                    return response.json();
                else
                    return response.json()
                        .then(data => {throw new Error(data.message)});
            })
            .then(data => confirmRsvp(data))
            .catch(err => handleError(err));
    }
}

async function loadEvents() {
    const url = "http://localhost:8080/api/v2/events";

    // GET is the default HTTP method for fetch
    fetch(url)
        .then(response => {
            if (response.ok)
                return response.json();
            else
                return response.json()
                    .then(data => {throw new Error(data.message)});
        })
        .then(data => populateCalendar(data))
        .catch(err => handleError(err));
}

function confirmRsvp(data) {
    setStatusMessage(data.rsvpStatus);
    hideRsvpForm();
};

function populateCalendar(data) {
    // data.forEach(element => element.type = "Event");

    $("#evoCalendar")
        .evoCalendar({
            calendarEvents: data,
            theme: 'Midnight Blue'
        })
        .evoCalendar('selectYear', new Date().getFullYear())
        .evoCalendar('selectMonth', new Date().getMonth())
        .on('selectEvent', function (event, activeEvent) {
            showRsvpForm(activeEvent);
            setStatusMessage("");
        })
        .on('selectDate', function (newDate, oldDate) {
            hideRsvpForm();
            setStatusMessage("");
        });
};

function setStatusMessage(text) {
    document.querySelector("#statusMessage").innerText = text;
};

function handleError (error) {
    setStatusMessage(error);
    console.log(error);
};

function showRsvpForm (activeEvent) {
    if (activeEvent) {
        document.querySelector("#eventId").value = activeEvent.id;
        document.querySelector("div.form").style.display = "block";
    } else {
        hideRsvpForm();
    }
};

function hideRsvpForm () {
    document.querySelector("#eventId").value = -1;
    document.querySelector("div.form").style.display = "none";
};

