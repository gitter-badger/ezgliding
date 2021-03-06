// Copyright 2014 The ezgliding Authors.
//
// This file is part of ezgliding.
//
// ezgliding is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ezgliding is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ezgliding.  If not, see <http://www.gnu.org/licenses/>.
//
// Author: Ricardo Rocha <rocha.porto@gmail.com>

package welt2000

import (
	"fmt"
	"testing"
)

func TestList(t *testing.T) {
	releases, err := List("./updates.xml")
	if err != nil {
		t.Fatalf("Failed to list releases :: %v", err)
	}
	if len(releases) < 1 {
		t.Fatalf("Got wrong number of releases :: %v", len(releases))
	}
}

func TestFetch(t *testing.T) {
	release, err := Fetch("./release.txt")
	if err != nil {
		t.Fatalf("Failed to fetch release :: %v", err)
	}

	fmt.Println("Release :: %v", release)
}
