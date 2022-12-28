package domain

type PlayerRepositoryStub struct {
	players []Player
}

func (p PlayerRepositoryStub) FindAll() ([]Player, error) {
	return p.players, nil
}

func NewPlayerRepositoryStub() PlayerRepositoryStub {
	players := []Player{
		{"2001", "Pralay", "Bangalore", "560078", "active", "1997-04-01"},
		{"2002", "Nirmal", "Kolkata", "700028", "active", "2001-05-28"},
		{"2003", "Dishani", "Chennai", "600036", "active", "2003-03-20"},
		{"2004", "Somali", "Bangalore", "560034", "inactive", "1995-08-17"},
		{"2005", "Pratik", "Delhi", "110092", "active", "1992-02-02"},
		{"2006", "Vishnu", "Chennai", "600002", "inactive", "1998-04-19"},
		{"2007", "Nirmal", "Mumbai", "400066", "active", "1999-07-21"},
		{"2008", "Disha", "Bhubaneshwar", "750025", "active", "1995-06-23"},
	}

	return PlayerRepositoryStub{players}
}
