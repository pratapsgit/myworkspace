package sports

import (
	"encoding/json"
	"encoding/xml"
	"net/http"

	"github.com/pratapsgit/myworkspace/go-play-area/sportsacademy/service"
)

type PlayerHandlers struct {
	Playerservice service.PlayerService
}

func (ph *PlayerHandlers) GetAllPlayers(w http.ResponseWriter, r *http.Request) {
	// players := []domain.Player{
	// 	{Id: "84764", Name: "Samir", City: "Bangalore", ZipCode: "560078", Status: "active", DateOfBirth: "1998-04-27"},
	// 	{Id: "64848", Name: "Nasir", City: "Kolkata", ZipCode: "700056", Status: "active", DateOfBirth: "1995-02-16"},
	// 	{Id: "26398", Name: "Sahana", City: "Delhi", ZipCode: "110034", Status: "active", DateOfBirth: "1997-04-18"},
	// 	{Id: "86744", Name: "Banshi", City: "Chennai", ZipCode: "600045", Status: "active", DateOfBirth: "1996-08-26"},
	// 	{Id: "19474", Name: "Krishna", City: "Bangalore", ZipCode: "560034", Status: "active", DateOfBirth: "1995-06-22"},
	// 	{Id: "74633", Name: "Swapna", City: "Mumbai", ZipCode: "400031", Status: "active", DateOfBirth: "1993-05-18"},
	// }

	players, _ := ph.Playerservice.GetAllPlayers()

	if r.Header.Get("Content-Type") == "application/xml" {
		w.Header().Add("Content-Type", "application/xml")
		xml.NewEncoder(w).Encode(players)
	} else {
		w.Header().Add("Content-Type", "application/json")
		json.NewEncoder(w).Encode(players)
	}
}
