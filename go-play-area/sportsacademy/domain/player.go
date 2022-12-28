package domain

// Bussiness Object
type Player struct {
	Id          string
	Name        string
	City        string
	ZipCode     string
	Status      string
	DateOfBirth string
}

type PlayerRepository interface {
	FindAll() ([]Player, error)
}
