$(function () {
    $("#rsvp-form").submit(function (e) {
        var id = $("#event-id").val();
        var email = $("#email").val();

        if (id && id > 0 && email) {
            $.ajax({
                url: "http://localhost:8080/api/rsvp/",
                method: "POST",
                contentType: "application/json",
                data: JSON.stringify({
                    eventId: id,
                    memberEmail: email
                }),
                success: function (data) {
                    confirmRsvp(data);
                },
                error: handleError,
                dataType: "json"
            });
        }

        e.preventDefault();
    });

    $.ajax({
        url: "http://localhost:8080/api/v2/events/",
        success: function (data) {
            populateCalendar(data);
        },
        error: handleError,
        dataType: "json"
    });

    var confirmRsvp = function (data) {
        setStatusMessage(data.status);
        hideRsvpForm();
    };

    var populateCalendar = function (data) {
        data.forEach(element => element.type = 'Event');

        $('#evoCalendar')
            .evoCalendar({
                calendarEvents: data,
                theme: 'Midnight Blue'
            })
            .evoCalendar('selectYear', 2023)
            .evoCalendar('selectMonth', 10)
            .on('selectEvent', function (event, activeEvent) {
                showRsvpForm(activeEvent);
                setStatusMessage("");
            })
            .on('selectDate', function (newDate, oldDate) {
                hideRsvpForm();
                setStatusMessage("");
            });
    };

    var setStatusMessage = function (text) {
        $("#status-message").text(text);
    };

    var handleError = function (error) {
        setStatusMessage(error.responseJSON.message);
        console.log(error);
    };

    var showRsvpForm = function (activeEvent) {
        if (activeEvent) {
            $("#event-id").val(activeEvent.id);
            $("#rsvp-form").show();
        } else {
            hideRsvpForm();
        }
    };

    var hideRsvpForm = function () {
        $("#event-id").val(-1);
        $("#rsvp-form").hide();
    };

    hideRsvpForm();
});
