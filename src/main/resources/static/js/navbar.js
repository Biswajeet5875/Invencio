// const navItems = document.querySelectorAll(".nav-item");

// navItems.forEach((navItem) => {
//   navItem.addEventListener("click", () => {
//     navItems.forEach((item) => {
//       item.classList.remove("active");
//     });

//     navItem.classList.add("active");
//   });
// });
// Function to get a cookie value by name
function getCookie(name) {
  const cookieArr = document.cookie.split(";"); // Split cookies into an array
  for (let i = 0; i < cookieArr.length; i++) {
    const cookiePair = cookieArr[i].split("="); // Split each cookie into name and value
    const cookieName = cookiePair[0].trim(); // Remove leading/trailing whitespace
    if (cookieName === name) {
      return decodeURIComponent(cookiePair[1]); // Return the value of the cookie
    }
  }
  return null; // Return null if the cookie is not found
}

// Function to handle anchor click
function handleDashboardClick() {
  const userId = getCookie("username"); // Retrieve the 'userId' cookie value
  if (userId) {
    console.log("User ID from cookie:", userId);
    // Redirect to the dashboard or perform another action
    window.location.href = `/${userId}`;
  } else {
    console.log("No user ID found in cookies");
    alert("You are not logged in.");
  }
}
