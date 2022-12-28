package app

import (
	"encoding/json"
	"encoding/xml"
	"fmt"
	"net/http"
)

type Student struct {
	Name    string `json:"student_name" xml:"student_name"`
	College string `json:"studies_at" xml:"studies_at"`
	ZipCode string `json:"lives_at" xml:"lives_at"`
}

func greet(w http.ResponseWriter, r *http.Request) {
	fmt.Fprint(w, "Hello World!!")
}

func getAllStudents(w http.ResponseWriter, r *http.Request) {
	students := []Student{
		{"Pranil", "PES", "560089"},
		{"Sawpesh", "VIT", "560045"},
		{"Bavwsh", "PES", "560089"},
		{"Nirmal", "VIT", "560054"},
		{"Soumya", "VIT", "560067"},
	}

	if r.Header.Get("Content-Type") == "application/xml" {
		w.Header().Add("Content-Type", "application/xml")
		xml.NewEncoder(w).Encode(students)
	} else {
		w.Header().Add("Content-Type", "application/json")
		json.NewEncoder(w).Encode(students)
	}

}
