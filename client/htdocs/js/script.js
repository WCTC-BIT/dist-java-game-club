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
                error: function (error) {
                    console.log(error);
                },
                dataType: "json"
            });
        }

        e.preventDefault();
    });

    $.ajax({
        url: "http://localhost:8080/api/events/",
        success: function (data) {
            populateCalendar(data);
        },
        error: function (error) {
            console.log(error);
        },
        dataType: "json"
    });

    var confirmRsvp = function(data) {
      setConfirmation(data.status);
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
                setConfirmation("");
            })
            .on('selectDate', function (newDate, oldDate) {
                hideRsvpForm();
                setConfirmation("");
            });
    };

    var setConfirmation = function(text) {
        $("#confirmation").text(text);
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
