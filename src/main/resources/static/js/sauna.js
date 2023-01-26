const saunalist = /*[[${saunalist}]]*/"saunalist";

//sauna_tempの配列
let saunaTempArray = [];
//sauna_tempデータの準備
const saunaTemp = saunalist.map(x=>x.saunaTemp);
for(var i = 0; i < saunaTemp.length; i++){
  saunaTempArray.push(saunaTemp[i]);
}

//sauna_satisfactionの配列
let saunaSatisfactionArray = [];
//sauna_satisfactionデータの準備
const saunaSatisfaction = saunalist.map(x=>x.saunaSatisfaction);
for(var i = 0; i < saunaSatisfaction.length; i++){
  saunaSatisfactionArray.push(saunaSatisfaction[i]);
}


window.onload = function(){
  ctx = document.getElementById("saunaTemp").getContext('2d');
  window.myBar = new Chart(ctx, {
    type: 'bar',
    data: barChartData,
    options: complexChartOption
  });
};
var barChartData = {
  labels: saunaTempArray,
  datasets: [
    {
      type: 'bar',
      label: "満足度(%)",
      data: saunaSatisfactionArray,
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(255, 159, 64, 0.2)',
        'rgba(255, 205, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(242, 87, 87, 0.9)',
        'rgba(153,242,87,0.9)',
        'rgba(87, 138, 242, 0.9)',
        'rgba(242,231,87,0.9)'
        ],
        borderColor: [
        'rgb(255, 99, 132)',
        'rgb(255, 159, 64)',
        'rgb(255, 205, 86)',
        'rgb(75, 192, 192)',
        'rgb(54, 162, 235)',
        'rgb(153, 102, 255)',
        'rgba(242, 87, 87, 0.9)',
        'rgba(87, 138, 242, 0.9)',
        'rgba(242,231,87,0.9)'
        ],
        yAxisID: "y-axis-1",
        borderWidth: 1,
          lineTension: 0,
          fill: false,
    },
  ],
};
var complexChartOption = {
  responsive: true,
  scales: {
    yAxes: [{
      id: "y-axis-1",
      type: "linear",
      position: "right",
      scaleLabel: {             //軸ラベル設定
        display: true,           //表示設定
        labelString: '満足度(％)',  //ラベル
      },
      ticks: {
        min: 0,
        stepSize: 10
      },
      gridLines: {
        drawOnChartArea: false,
      },
    }],
    xAxes: [{                         //x軸設定
          display: true,                //表示設定
          scaleLabel: {                 //軸ラベル設定
             display: true,             //表示設定
             labelString: 'サウナ室温度(℃)',  //ラベル
          },
      }],
  }
};

