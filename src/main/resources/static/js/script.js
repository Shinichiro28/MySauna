//登録ボタンを押すと投稿フォームが消える
document.querySelector('#btn-finish').addEventListener('click', function(){
  document.querySelector('#c-overlay').classList.remove(".c-overlay");
});

//登録はこちらを押すと投稿フォーム画面が出る
document.querySelector('#btn-start').addEventListener('click', function(){
  document.querySelector('#c-overlay').classList.add(".c-overlay");
});