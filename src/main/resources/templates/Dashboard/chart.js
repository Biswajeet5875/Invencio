// Get the canvas element by its ID
const ctx = document.getElementById("myChart").getContext("2d");

// Create a new Chart instance
const myChart = new Chart(ctx, {
  type: "bar", // Type of chart ('line', 'bar', 'pie', etc.)
  data: {
    labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"], // Labels for the X-axis
    datasets: [
      {
        label: "# of Votes",
        data: [12, 19, 13, 15, 20, 10], // Data points
        backgroundColor: [
          "rgba(255, 99, 132, 0.2)",
          "rgba(54, 162, 235, 0.2)",
          "rgba(255, 206, 86, 0.2)",
          "rgba(75, 192, 192, 0.2)",
          "rgba(153, 102, 255, 0.2)",
          "rgba(255, 159, 64, 0.2)",
        ],
        borderColor: [
          "rgba(255, 99, 132, 1)",
          "rgba(54, 162, 235, 1)",
          "rgba(255, 206, 86, 1)",
          "rgba(75, 192, 192, 1)",
          "rgba(153, 102, 255, 1)",
          "rgba(255, 159, 64, 1)",
        ],
        borderWidth: 1, // Border width of the bars
      },
    ],
  },
  options: {
    responsive: true,
    scales: {
      y: {
        beginAtZero: true, // Start the Y-axis at zero
      },
    },
  },
});
