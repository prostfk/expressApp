validatePassword = (password) => {
    return password.length >= 6 && password.length <= 25;
};
validateUsername = (username) => {
    return username.length >= 3 && username.length <= 30;
};

validateTitle = (title) => {
    return title.length > 10 && title.length < 100;
};

validateContent = (content) => {
    return content.length > 30 && content.length < 100000000000;
};

validateGenre = (genre) => {
    console.log(genre);
    return genre === 'Drama' || genre === 'Horror' || genre === 'Comedy' || genre === 'Science' || genre === 'Fantasy'
};

module.exports.validateGenre = validateGenre;
module.exports.validateTitle = validateTitle;
module.exports.validateContent = validateContent;
module.exports.validatePassword = validatePassword;
module.exports.validateUsername = validateUsername;